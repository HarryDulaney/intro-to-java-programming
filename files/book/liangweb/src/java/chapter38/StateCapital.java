package chapter38;

import java.util.*;

public class StateCapital {

    String[][] statecapital = { {"Alabama", "Montgomery"}, {"Alaska", "Juneau"},
    {"Arizona", "Phoenix"}, {"Arkansas", "Little Rock"}, {"California",
    "Sacramento"}, {"Colorado", "Denver"}, {"Connecticut", "Hartford"},
    {"Delaware", "Dover"}, {"Florida", "Tallahassee"}, {"Georgia", "Atlanta"},
    {"Hawaii", "Honolulu"}, {"Idaho", "Boise"}, {"Illinois", "Springfield"},
    {"Maryland", "Annapolis"}, {"Minnesota", "Saint Paul"}, {"Iowa",
    "Des Moines"}, {"Maine", "Augusta"}, {"Kentucky", "Frankfort"}, {"Indiana",
    "Indianapolis"}, {"Kansas", "Topeka"}, {"Louisiana", "Baton Rouge"},
    {"Oregon", "Salem"}, {"Oklahoma", "Oklahoma City"}, {"Ohio", "Columbus"},
    {"North Dakota", "Bismark"}, {"New York", "Albany"}, {"New Mexico",
    "Santa Fe"}, {"New Jersey", "Trenton"}, {"New Hampshire", "Concord"},
    {"Nevada", "Carson City"}, {"Nebraska", "Lincoln"}, {"Montana", "Helena"},
    {"Missouri", "Jefferson City"}, {"Mississippi", "Jackson"},
    {"Massachusettes", "Boston"}, {"Michigan", "Lansing"}, {"Pennslyvania",
    "Harrisburg"}, {"Rhode Island", "Providence"}, {"South Carolina",
    "Columbia"}, {"South Dakota", "Pierre"}, {"Tennessee", "Nashville"},
    {"Texas", "Austin"}, {"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"},
    {"Virginia", "Richmond"}, {"Washington", "Olympia"}, {"West Virginia",
    "Charleston"}, {"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"}
  };

  List list = Arrays.asList(statecapital);
  
  /** Creates a new instance of StateCapital */
  public StateCapital() {
    Collections.shuffle(list);
  }
  
  int next = 0;
  
  public String nextState() {
    return ((String[])(list.get(next)))[0];
  }
  
  public String nextCapital() {
    return ((String[])(list.get(next)))[1];
  }
  
  public void moveToNext() {
    next = ++next % 50;
  }
}