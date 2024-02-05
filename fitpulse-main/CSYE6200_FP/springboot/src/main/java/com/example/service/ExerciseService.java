package com.example.service;

import com.example.entity.Exercise;
import com.example.mapper.ExerciseMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {
    @Resource
    private ExerciseMapper exerciseMapper;

    /**
     * total: total number of search
     * list: data list
     * @param pageNum current page number
     * @param pageSize size of every page
     * @return the list of data
     */

    public PageInfo<Exercise> selectPage(Integer pageNum, Integer pageSize, String title, String targetMuscle, String difficultyLevel){
        // get all data from
        List<Exercise> allExercises = exerciseMapper.selectAll(title, targetMuscle, difficultyLevel);

        // use Stream to filter the data that not suppose to show
        List<Exercise> filteredExercises = allExercises.stream()
                .filter(exercise -> exercise.getStatus() == 1)
                .sorted(Comparator.comparing(Exercise::getTitle))
                .collect(Collectors.toList());

        // handle pagination manually
        int fromIndex = (pageNum - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, filteredExercises.size());

        List<Exercise> pageData = filteredExercises.subList(fromIndex, toIndex);

        // create PageInfo Object
        PageInfo<Exercise> pageInfo = new PageInfo<>(pageData);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(filteredExercises.size());

        return pageInfo;
    }

    public void add(Exercise exercise) {
        exerciseMapper.insert(exercise);
    }

    public void updateById(Exercise exercise) {
        exerciseMapper.updateById(exercise);
    }

    public void pseudoDeleteById(Integer id) {
        exerciseMapper.pseudoDeleteById(id);
    }

    public void delete(Integer id) {
        exerciseMapper.delete(id);
    }

    public void addCSVExcercises(List<String> dataList) {

        List<Exercise> exercises = new ArrayList<>();

        System.out.println(dataList.get(0));
        dataList.forEach(data -> {
            String[] details = data.split(",");
            Exercise exercise = new Exercise();
            exercise.setTitle(details[0]);
            exercise.setTargetMuscle(details[1]);
            exercise.setEquipment(details[2]);
            exercise.setDescription(details[3]);
            exercise.setDifficultyLevel(details[4]);
            exercise.setRepetitionRange(details[5]);
            exercises.add(exercise);
        });

        // load all the expenses from the list
        exercises.forEach(exercise -> add(exercise));
    }
}
