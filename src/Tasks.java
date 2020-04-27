import java.text.SimpleDateFormat;
import java.util.Date;

public class Tasks {
    private String date;
    private String time;
    private String task;
    private String location;
    private String user;


    private Tasks(String date, String time, String task, String location, String user) {
        this.date = date;
        this.time = time;
        this.task = task;
        this.location = location;
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getTask() {
        return task;
    }

    public String getLocation() {
        return location;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", task='" + task + '\'' +
                ", location='" + location + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    public static class Builder {
        private String date;
        private String time;
        private String task;
        private String location;
        private String user;


        public Builder() {

        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setTime(String time) {
            this.time = time;
            return this;
        }

        public Builder setTask(String task) {
            this.task = task;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setUser(String user) {
            this.user = user;
            return this;
        }

        public Tasks build() {
            return new Tasks(date, time, task, location, user);
        }
    }
}
