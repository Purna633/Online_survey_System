package SController;

import SEncap.SEncap;
import SUtil.SUtil;

public class SControll {
    private final SUtil sUtil;
    public  SControll()
    {
        sUtil = new SUtil();

    }
    public void addSurvey(String q1,String q2,String q3,String q4,String rating,String des ,String email)
    {
        SEncap survey=new SEncap(q1,q2,q3,q4,rating,des,email);
        sUtil.addSurvey(survey);
    }
    public void updateSurvey(String q1,String q2,String q3,String q4,String rating,String des ,String email)
    {
        SEncap survey=new SEncap(q1,q2,q3,q4,rating,des,email);
        sUtil.updateSurvey(survey);
    }
    public void deleteSurvey(String email)
    {
        SEncap survey=new SEncap(email);

        sUtil.deleteSurvey(survey);
    }
}
