package SEncap;

public class SEncap {
    String q1;
    String q2;
    String q3;
    String q4;
    String rating;
    String des;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    public SEncap(String q1, String q2, String q3, String q4, String rating, String des,String email) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.rating = rating;
        this.des = des;
        this.email=email;
    }

    @Override
    public String toString() {
        return "SEncap{" +
                "q1='" + q1 + '\'' +
                ", q2='" + q2 + '\'' +
                ", q3='" + q3 + '\'' +
                ", q4='" + q4 + '\'' +
                ", rating='" + rating + '\'' +
                ", des='" + des + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    public SEncap(String email) {

        this.email = email;
    }
}
