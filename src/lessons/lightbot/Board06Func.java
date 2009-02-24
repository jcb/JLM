package lessons.lightbot;

import jlm.lesson.Lesson;
import universe.bugglequest.Direction;

public class Board06Func extends LightBotExercise {

	public Board06Func(Lesson lesson) {
		super(lesson);
				
		/* Create initial situation */
		LightBotWorld myWorld = new LightBotWorld("Mars", 8, 8);
		
		new LightBotEntity(myWorld, "D2R2", 1, 2, Direction.EAST);

		myWorld.setHeight(3, 2, 1);
		myWorld.setHeight(4, 2, 2);
		myWorld.setHeight(4, 3, 3);
		myWorld.setHeight(4, 4, 4);
		myWorld.addLight( 4, 4);
		for (int i=1;i<7;i++)
			myWorld.setHeight(i, 5, 2);
		myWorld.addLight(1, 5);
		myWorld.addLight(6, 5);
		
		setup(myWorld);
	}
}