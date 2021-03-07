import java.util.List;

public interface Criteria {
   public List<Person> meetCriteria(List<Person> persons);
}


/*
here actually you can have Generic Type so that any class can implement this Criteria
*/

public interface Criteria<T> {
   public List<T> meetCriteria(List<T> list);
}
