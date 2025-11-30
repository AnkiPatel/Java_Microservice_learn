package com.pravisolutions.model;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//way to define getters and setters at class level.

/*
@Getter
@Setter
class ABC {
    private string id;
}
 */

@Getter
//@NoArgsConstructor // way to define default constructor
@AllArgsConstructor  // For defining constructor for all the member variables
@RequiredArgsConstructor //For defining constructor for selected member variables, mostly used
// NOTE: with RequiredArgsConstructor, you can have final variable easily as you can initialize with this constructor
@ToString  // For automatic generation of toString method
@EqualsAndHashCode //Advisable to implement this method
//@Data //Composite annotation, include several other annotation (@Getter, @Setter, @ToString ,@EqualsAndHashCode, @RequiredArgsConstructor)
@Component
@Scope("prototype")
public class Teacher {

    // 1) For each field you can have this annotation.
    //@Getter
    //@Setter
    //private String name;

    // 2) If for all the fields you want getters and setters with same access level, you can define at class level.

    // 3) For setters you can define the access level. by default, it is public.

    @Setter(AccessLevel.PROTECTED)
    private String name;

    final private String id;

    @Setter
    private String classTeacherOf;

    public Teacher() {
        id = "ANE2345";
    }

}
