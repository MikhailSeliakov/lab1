package com.lab1.lab1.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    private ArrayList<String> arrayList = new ArrayList<>();
    private HashMap<Integer, String> hashMap = new HashMap<>();
    private int hashMapKey = 0;  // Ключ для HashMap

    // 1. Метод для добавления строки в ArrayList
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s) {
        arrayList.add(s);
        return "Added to ArrayList: " + s;
    }

    // 2. Метод для отображения всех элементов ArrayList
    @GetMapping("/show-array")
    public ArrayList<String> showArrayList() {
        return arrayList;
    }

    // 3. Метод для добавления строки в HashMap
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String s) {
        hashMap.put(hashMapKey++, s);
        return "Added to HashMap: Key = " + (hashMapKey - 1) + ", Value = " + s;
    }

    // 4. Метод для отображения всех элементов HashMap
    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return hashMap;
    }

    // 5. Метод для отображения количества элементов в ArrayList и HashMap
    @GetMapping("/show-all-length")
    public String showAllLength() {
        return "ArrayList size: " + arrayList.size() + ", HashMap size: " + hashMap.size();
    }

}
