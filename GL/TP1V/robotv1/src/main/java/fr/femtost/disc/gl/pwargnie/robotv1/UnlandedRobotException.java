package fr.femtost.disc.gl.pwargnie.robotv1;

public class UnlandedRobotException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6499492794528190739L;

	public UnlandedRobotException() {
        super("Le robot doit être posé avant tout déplacement");
    }
}
