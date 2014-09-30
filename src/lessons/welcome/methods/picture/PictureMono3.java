package lessons.welcome.methods.picture;

import java.awt.Color;

import plm.core.model.lesson.ExerciseTemplated;
import plm.core.model.lesson.Lesson;
import plm.universe.Direction;
import plm.universe.bugglequest.BuggleWorld;
import plm.universe.bugglequest.SimpleBuggle;

public class PictureMono3 extends ExerciseTemplated {

	public PictureMono3(Lesson lesson) {
		super(lesson);
		BuggleWorld myWorld =  new BuggleWorld("World",63,63);
		myWorld.setDelay(5);
		new SimpleBuggle(myWorld, "Picasso", 0, 62, Direction.EAST, Color.black, Color.lightGray);
				
		setup(myWorld);
	}
}
