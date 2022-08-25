package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.GroupMapper;
import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.models.enums.Day;
import kg.megacom.students1.models.requests.GroupRequest;
import kg.megacom.students1.repositiries.GroupRepo;
import kg.megacom.students1.repositiries.LessonRepo;
import kg.megacom.students1.services.CourseService;
import kg.megacom.students1.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepo groupRepo;
    private final GroupMapper groupMapper;
    private final CourseService courseService;
    private final LessonRepo lessonRepo;
    public  GroupServiceImpl(GroupRepo groupRepo, GroupMapper groupMapper, CourseService courseService, LessonRepo lessonRepo) {
        this.groupRepo = groupRepo;
        this.groupMapper = groupMapper;
        this.courseService = courseService;
        this.lessonRepo = lessonRepo;
    }
    private List<Date> getLessonsDates(List<Day> days, int duration, Date startDate)
    {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        //days=[MONDAY, WEDNESDAY, FRIDAY]
        // [2, 4, 6]
        // []

        for (int i = 0; i < duration; ){

            long count = days
                    .stream()
                    .map(x->x.getDayValue())
                    .filter(x-> x == calendar.get(Calendar.DAY_OF_WEEK))
                    .count();

            if (count == 1) {
                i++;
                dates.add(calendar.getTime());
            }

            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }
        System.out.println(dates);
        return dates;

    }

    @Override
    public Group createGroup(GroupDto groupDto) {

        Group group = groupMapper.toEntity(groupDto);
        groupRepo.save(group);
            return group;
    }
    @Override
    public List<GroupDto> findAll() {
        List<Group> groupList = groupRepo.findAll();
        return groupMapper.toDtoList(groupList);
    }

    @Override
    public Group update(Long id, String name) {
        groupRepo.update(id, name);
        return groupRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        groupRepo.delete(groupRepo.findById(id).get());
    }

    @Override
    public Group createV2(GroupRequest groupRequest) {
        System.out.println(groupRequest);
        Course course = courseService.findById(groupRequest.getCourseId());
        System.out.println(course);

        if (course.getDuration() <= 0)
            throw new RuntimeException("Длительность не может быть меньше или равна нулю!");
        List<Date> lessonsDates = getLessonsDates(groupRequest.getDays(), course.getDuration(), groupRequest.getStartDate());
        Date maxDate = lessonsDates
                .stream()
                .max(Date::compareTo)
                .get();


        Group group = new Group();
        group.setCourse(course);
        group.setStartDate(groupRequest.getStartDate());
        group.setEndDate(maxDate);
        group.setName(groupRequest.getGroupTitle());

        group = groupRepo.save(group);

        Group finalGroup = group;

        List<Lesson> lessons = lessonsDates
                .stream()
                .map(x-> {
                    Lesson lesson = new Lesson();
                    lesson.setDay(x);
                    lesson.setGroup(finalGroup);
                    return lesson;
                })
                .collect(Collectors.toList());

        lessonRepo.saveAll(lessons);

        return group;

    }
}