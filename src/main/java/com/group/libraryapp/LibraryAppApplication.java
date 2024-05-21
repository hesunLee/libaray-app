package com.group.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryAppApplication { //class

  public static void main(String[] args) { //메인 Static Method

    //실제 스프링 애플리케이션을 시작한다.
    SpringApplication.run(LibraryAppApplication.class, args);
  }
}
