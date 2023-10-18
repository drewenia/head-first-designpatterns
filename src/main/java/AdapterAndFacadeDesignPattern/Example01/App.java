package AdapterAndFacadeDesignPattern.Example01;

public class App {
    public static void main(String[] args) {
        EnemyTank rx7Tank = new EnemyTank();
        EnemyRobot fredToRobot = new EnemyRobot();

        EnemyAttacker robotAdapter = new EnemyRobotAdapter(fredToRobot);

        System.out.println("The robot");

        fredToRobot.reactToHuman("Paul");
        fredToRobot.walkForward();
        fredToRobot.smashWithHands();

        System.out.println("The enemy tank");
        rx7Tank.assignDriver("Frank");
        rx7Tank.driveForward();
        rx7Tank.fireWeapon();

        System.out.println("The robot with adapter");
        robotAdapter.assignDriver("Mark");
        robotAdapter.driveForward();
        robotAdapter.fireWeapon();
    }
}
