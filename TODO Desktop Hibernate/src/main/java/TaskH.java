import javax.persistence.*;

@Entity
@Table(name="works")
public class TaskH {

    @Id
    @Column(name="n")
    public int n;

    @Column(name="task")
    public String task;

    @Column(name="isDone")
    public boolean isDone;

    public TaskH() {}
/*
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
*/
    @Override
    public String toString() {
        String result = (isDone)? "  <<< is done" : " <<< not done";
        return n + " " + task + " " + result;
    }
}
