package pl.edu.agh.soa.resources.model;

/**
 * Created by Dylek on 2016-05-07.
 */
public class Worker {
    private String name;
    private int id;
    private float salary;

    public Worker(String name,float salary,int id){
        this.name=name;
        this.salary=salary;
        this.id=id;
    }

    public  String getName(){
        return name;
    }
    public float getSalary(){
        return salary;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSalary(float salaty){
        this.salary=salaty;
    }
    public void setId(int id){this.id=id;}
    public int getId(){return id;}
}
