package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@XmlRootElement(name = "root")
@XmlType(propOrder={"studentList", "universitiesInfo","statisticalInfo","localDateTime"})
public class Root {

    private List<Student> studentList;
    private List<University> universityList;
    private List<Statistics> statisticalInfo;
    private LocalDateTime localDateTime;

    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    public List<Student> getStudentList() {
        return studentList;
    }
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    public List<University> getUniversitiesInfo() {
        return universityList;
    }
    public void setUniversitiesInfo(List<University> universityList) {
        this.universityList = universityList;
    }

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    public List<Statistics> getStatisticalInfo() {
        return statisticalInfo;
    }
    public void setStatisticalInfo(List<Statistics> statisticalInfo) {
        this.statisticalInfo = statisticalInfo;
    }

    @XmlElement(name = "processedAt")
    public String getLocalDateTime() {
        ZoneId targetZoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime = localDateTime.atZone(targetZoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String formattedDateTime = zonedDateTime.format(formatter);
        return formattedDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}







