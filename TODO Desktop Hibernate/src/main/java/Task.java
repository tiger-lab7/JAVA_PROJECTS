public class Task {

    public int n;
    public String task;
    public boolean isDone;

    public Task(int n, String task, boolean isDone) {
        this.n = n;
        this.task = task;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        String result = (isDone)? "  <<< выполнено" : " <<< не выполнено";
        return n + " " + task + " " + result;
    }
}

/*
enum IsDone {
    NOT_DONE(false), IS_DONE(true);

    public final boolean done;
    IsDone(boolean done) {
        this.done = done;
    }
}
*/