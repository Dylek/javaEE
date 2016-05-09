package pl.edu.agh.soa.soap;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Dylek on 2016-04-18.
 */
public class Student {
    @XmlElement(required = true)
    String name;
    @XmlElement(required = true)
    String surname;
    @XmlElement(required = true)
    int year;
    @XmlElement(required = true)
    String university;

    Student(String name2,String surname2,String university2,int year2){
        this.surname=surname2;
        this.name=name2;
        this.university=university2;
        this.year=year2;
    }


    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getUniversity(){
        return university;
    }
    public int getYear(){
        return year;
    }
    public void SetName(String name){
        this.name=name;
    }
    public void SetSurname(String surname){
        this.surname=surname;
    }
    public void SetUniversity(String name){
        this.university=name;
    }
    public void SetYear(int year){
        this.year=year;
    }

}
