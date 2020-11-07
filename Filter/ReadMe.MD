## Filter/Criteria Pattern
* Filter pattern or Criteria pattern is a design pattern that enables developers to filter a set of objects using different criteria and chaining them in a decoupled way through logical operations.
* This type of design pattern comes under structural pattern as this pattern combines multiple criteria to obtain single criteria.

Let say you have a Person class and now you have to filter Person based on its age, sex and status (of course you can have more filters in future).\
Moreover, you have conditions where it could be AND of two/more filters or it could be OR of two/more filters.

Some one can up with a class and static methods from each criteria like:
* List<Person> getSingles(List<Person>); 
* List<Person> getMales(List<Person>); 
* You can call singleMales = getSingles(getMales(persons));
* How would you call this for OR criaterias?

#### Union OR
Obviosly you can write a union function:
* List<Person> union(List<Person>,List<Person>){..};
* singlePeopleOrMales = union(getSingles(persons), getMales(persons))

#### Intersection AND
Now, in retrospect you may think we can write intersection function:
* List<Person> intersection(List<Person>,List<Person>){..};
* singleMales = intersection(getSingles(persons), getMales(persons))

#### Nice but 
* Every time you add a criateria you touch that big class and you keep on adding criterias.
* That will be very hard to maintain. 

## Better way - Filter/Criteria Patter
It would be awesome if : 
* If we could create lots of criaterias and hardly touch them.
* If we want to add criteria we dont touch existing code (less testing/impact).
* If we could combine them with AND/OR in whatever fasion and create a single criteria out of it. 

![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Filter/FilterPattern.png)

```
  Criteria male = new CriteriaMale();
  Criteria female = new CriteriaFemale();
  Criteria single = new CriteriaSingle();
  
  // this will call meetCriateria on single and then male criterias then it will perform INTERSECTION on it.
  Criteria singleMale = new AndCriteria(single, male);  
  
  // ..... then it will perform UNION on it.
  Criteria singleOrFemale = new OrCriteria(single, female);  
  
  singleMale(people); // returns single males 
  
  // You can keep adding criteria to create chain of them 
  Criteria singleMaleAgeThirtyPlus = new AndCriteria(singleMale, new CriteriaAge(30,Interger.MAX_VALUE));
  
  singleMaleAgeThirtyPlus.meetCriteria(people); // returns single males of 30+ age 
```
