package com.singtel.demo.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.singtel.demo.model.Animal;
import com.singtel.demo.model.Bird;
import com.singtel.demo.model.Butterfly;
import com.singtel.demo.model.Cat;
import com.singtel.demo.model.Chicken;
import com.singtel.demo.model.Clownfish;
import com.singtel.demo.model.Dog;
import com.singtel.demo.model.Dolphin;
import com.singtel.demo.model.Duck;
import com.singtel.demo.model.Fish;
import com.singtel.demo.model.Frog;
import com.singtel.demo.model.Parrot;
import com.singtel.demo.model.Rooster;
import com.singtel.demo.model.Shark;
import com.singtel.demo.util.Sound;
import com.singtel.demo.util.SpecializeFish.Specialize;

@Component
public class DummyData {
	
  public List<Animal> createData(){
	  List<Animal> list = new ArrayList<Animal>();
	  list.add( new Bird(true, true, true, Sound.BIRD_DEFAULT)); //assuming bird can't swim but swim & sing
	  list.add( new Duck(Sound.BIRD_DUCK));           // assuming duck can walk,fly,swim and sing
	  list.add( new Chicken(Sound.BIRD_CHICKEN));    // As mentioned can't fly. assuming bird can't swim but walk & sing. 
	  
	  //composite mapping 
	  list.add( new Rooster(Sound.BIRD_ROOSTER_DANISH).getBird()); // can fly but can't swim
	  
	  list.add( new Parrot(Sound.BIRD_PARROT_LIVING_WITH_ROOSTER)); // can fly but can't swim
	  list.add( new Fish(Specialize.DEFAULT));
	  list.add( new Shark());
	  list.add( new Clownfish());
	  list.add( new Dolphin());
	  list.add( new Frog()); // assuming can't sing
	  list.add( new Dog());// assuming can't sing
	  list.add( new Butterfly());  // can fly but can't swim
	  list.add( new Cat()); // assuming can't sing
	  
	  //total fly(bird,duck, rooster, parrot & butterfly) == 5
	  //total walk(bird,duck, chicken, rooster, parrot, frog, Dog and cat) == 8
	  //total swim(duck,fish, shark, Clownfish, Dolphin, Frog, dog & cat)  ==8
	 //total sing(bird, duck,Chicken,rooster,parrot)  ==5
	  
	  return list;
  }
}
