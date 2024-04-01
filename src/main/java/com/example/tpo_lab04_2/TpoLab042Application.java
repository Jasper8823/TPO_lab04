package com.example.tpo_lab04_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TpoLab042Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TpoLab042Application.class, args);
        Scanner scanner = new Scanner(System.in);
        ARepository ar = context.getBean(ARepository.class);
        BRepository br = context.getBean(BRepository.class);
        URepository ur = context.getBean(URepository.class);
        RRepository rr = context.getBean(RRepository.class);
        int choice=0,choice2=0;
        do{
            System.out.println("What do you want to do?");
            System.out.println("1. View data");
            System.out.println("2. Add data");
            System.out.println("3. Delete data");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            System.out.println("What table?");
            System.out.println("1. User");
            System.out.println("2. Blog");
            System.out.println("3. Article");
            System.out.println("4. Role");
            choice2=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Do you want to see?");
                    System.out.println("1. All table");
                    System.out.println("2. By id");
                    choice = scanner.nextInt();
                    if(choice==1){
                        switch (choice2){
                            case 1:
                                List<User> list1 = ur.seeAll();
                                for(User u : list1){
                                    System.out.println(u);
                                }
                                break;
                            case 2:
                                List<Blog> list2 = br.seeAll();
                                for(Blog u : list2){
                                    System.out.println(u);
                                }
                                break;
                            case 3:
                                List<Article> list3 = ar.seeAll();
                                for(Article u : list3){
                                    System.out.println(u);
                                }
                            break;
                            case 4:
                                List<Role> list4 = rr.seeAll();
                                for(Role u : list4){
                                    System.out.println(u);
                                }
                                break;
                        }
                    }else{
                        Long choice3;
                        System.out.println("Insert id");
                        choice3 = scanner.nextLong();
                        switch (choice2){
                            case 1:
                                System.out.println(ur.findByLongId(choice3));
                                break;
                            case 2:
                                System.out.println(br.findByLongId(choice3));
                                break;
                            case 3:
                                System.out.println(ar.findByLongId(choice3));
                                break;
                            case 4:
                                System.out.println(rr.findByLongId(choice3));
                                break;
                        }
                    }
                    choice=1;
                    break;
                case 2:
                    String name;
                    switch (choice2){
                        case 1:
                            System.out.println("Insert an email");
                            name = scanner.nextLine();
                            name = scanner.nextLine();
                            User u = new User(name);
                            ur.save(u);
                            break;
                        case 2:
                            System.out.println("Insert an name");
                            name = scanner.nextLine();
                            name = scanner.nextLine();
                            Long idy;
                            System.out.println("Insert author id");
                            idy = scanner.nextLong();
                            Blog b = new Blog(name,ur.findByLongId(idy));
                            br.save(b);
                            break;
                        case 3:
                            System.out.println("Insert an title");
                            name = scanner.nextLine();
                            name = scanner.nextLine();
                            Long idu, idb;
                            System.out.println("Insert author id");
                            idu = scanner.nextLong();
                            System.out.println("Insert blog id");
                            idb = scanner.nextLong();
                            Article a = new Article(name,ur.findByLongId(idu),br.findByLongId(idb));
                            ar.save(a);
                            break;
                        case 4:
                            System.out.println("Insert an name");
                            name = scanner.nextLine();
                            name = scanner.nextLine();
                            Role r = new Role(name);
                            rr.save(r);
                            break;
                    }
                    break;
                case 3:
                    Long choice3;
                    System.out.println("Insert id");
                    choice3 = scanner.nextLong();
                    switch (choice2){
                        case 1:
                            ur.deleteById(choice3);
                            break;
                        case 2:
                            br.deleteById(choice3);
                            break;
                        case 3:
                            ar.deleteById(choice3);
                            break;
                        case 4:
                            rr.deleteById(choice3);
                            break;
                    }
                    break;
            }
        }while (choice!=4);
    }

}
