package jlm.ui;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import jlm.bugglequest.Game;
import jlm.bugglequest.Logger;
import jlm.bugglequest.World;
import jlm.event.GameListener;

import lessons.Exercise;

public class WorldComboListAdapter extends AbstractListModel implements ComboBoxModel, GameListener {

	private static final long serialVersionUID = -4669130955472219209L;
	private Game game;
	private World selectedWorld;
	private Exercise currentExercise;
	
	public WorldComboListAdapter(Game game) {
		this.game = game;
		this.game.addGameListener(this);
		this.currentExercise = this.game.getCurrentLesson().getCurrentExercise();
		this.selectedWorld = this.game.getSelectedWorld();
	}

	@Override
	public Object getElementAt(int index) {
		return this.currentExercise.getWorld(index);
	}

	@Override
	public int getSize() {
		return this.currentExercise.worldCount();
	}

	@Override
	public Object getSelectedItem() {
		return this.selectedWorld;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		if (anItem instanceof World) {
			World w = (World) anItem;
			this.selectedWorld = w;
			this.game.setSelectedWorld(w);
		} else {
			Logger.log("WordComboListAdapter:setSelectedItem", "parameter is not a world");
		}
	}

	
	@Override
	public void currentExerciseHasChanged() {
		this.currentExercise = this.game.getCurrentLesson().getCurrentExercise();
		this.selectedWorld = this.game.getSelectedWorld();
		fireContentsChanged(this, 0, this.currentExercise.worldCount()-1);
	}
	
	@Override
	public void currentLessonHasChanged() {
		// don't care
	}

	@Override
	public void lessonsChanged() {
		// don't care
	}

	@Override
	public void selectedWorldHasChanged() {
		this.selectedWorld = this.game.getSelectedWorld();
		fireContentsChanged(this, 0, this.currentExercise.worldCount()-1);		
	}
	
	@Override
	public void selectedBuggleHasChanged() {
		// don't care
	}
	
	@Override
	public void selectedWorldWasUpdated() {
		// don't care
	}
	
}