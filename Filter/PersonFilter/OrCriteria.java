import java.util.List;

public class OrCriteria implements Criteria {

   private Criteria criteria;
   private Criteria otherCriteria;

   public OrCriteria(Criteria criteria, Criteria otherCriteria) {
      this.criteria = criteria;
      this.otherCriteria = otherCriteria; 
   }

   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
      List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);
      
      Set<Person> set = new HashSet<>(firstCriteriaItems);
      for (Person person : otherCriteriaItems) {
         set.add(person);
      }
      
      return new ArrayList<>(set);
   }
}

/*
You can totally make this implementation as Generic type.
You never have to write these criterias for different classes. 
*/
public class OrCriteria<T> implements Criteria<T> {

   private Criteria<T> criteria;
   private Criteria<T> otherCriteria;

   public OrCriteria(Criteria<T> criteria, Criteria<T> otherCriteria) {
      this.criteria = criteria;
      this.otherCriteria = otherCriteria; 
   }

   @Override
   public List<T> meetCriteria(List<T> items) {
      List<T> firstCriteriaItems = criteria.meetCriteria(items);
      List<T> otherCriteriaItems = otherCriteria.meetCriteria(items);
      
      Set<T> set = new HashSet<>(firstCriteriaItems);
      for (T item : otherCriteriaItems) {
         set.add(item);
      }
      
      return new ArrayList<T>(set);
   }
}


