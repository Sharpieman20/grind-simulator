/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package sharpie.grindsim.main;

import sharpie.grindsim.agents.*;
import sharpie.grindsim.routes.*;
import sharpie.grindsim.routes.fullroutes.*;
import sharpie.grindsim.routes.netherexitroutes.*;
import sharpie.grindsim.utils.Settings;
import sharpie.grindsim.config.SimConfig;
import sharpie.grindsim.sim.GrindSimulator;
import sharpie.sim.config.UntilAttemptsConfig;

public class RunGrindSim {

    public static void main(String[] args) {

        Settings.initialize();

//        runPosposumentSim();

        runBlindTravelSim();
    }

    private static void runBlindTravelSim() {

        GrindSimulator grindSimulator = new GrindSimulator();

        int attempts = 1_000_000;

        SimConfig config = new UntilAttemptsConfig(attempts);

        config.routeToRun = new HypermodernBastionFull();

        grindSimulator.runSim(config);

        System.out.println(config.getResults());
    }

    private static void runPosposumentSim() {

        GrindSimulator grindSimulator = new GrindSimulator();

        int attempts = 5_000_000;

        SimConfig config = new UntilAttemptsConfig(attempts);

        MonumentResetAgent agent = new MonumentForcer();

        config.routeToRun = new PosposumentRoute(agent);

        grindSimulator.runSim(config);

        System.out.println(config.getResults());

        agent = new RDResetAgent(24);

        config.routeToRun = new PosposumentRoute(agent);

        grindSimulator.runSim(config);

        agent = new CoordRDResetAgent(24);

        config.routeToRun = new PosposumentRoute(agent);

        grindSimulator.runSim(config);

        System.out.println(config.getResults());

//        agent = new CoordRDResetAgent(18);
        agent = new RDResetAgent(18);

        config.routeToRun = new PosposumentRoute(agent);

        grindSimulator.runSim(config);

        System.out.println(config.getResults());

        agent = new CoordRDResetAgent(14);

        config.routeToRun = new PosposumentRoute(agent);

        grindSimulator.runSim(config);

        System.out.println(config.getResults());

        agent = new AggressiveCoordRDResetAgent(14);

        config.routeToRun = new PosposumentRoute(agent);

        grindSimulator.runSim(config);

        System.out.println(config.getResults());
    }

    private static void oldMain() {

        GrindSimulator grindSimulator = new GrindSimulator();

//        int attempts = 50_000_000;

        int attempts = 5_000_000;

//        int attempts = 500_000;

        SimConfig config = new UntilAttemptsConfig(attempts);

        config.routeToRun = new SimpleMonumentRoute(15);

//        config.routeToRun = new ResetForMonumentRuinedPortal(15, 7);

//        config.routeToRun = new HypermodernBastion();

        grindSimulator.runSim(config);

        System.out.println(config.getResults());

        config.routeToRun = new HypermodernBastion();

        grindSimulator.runSim(config);

        System.out.println(config.getResults());


        config.routeToRun = new ResetForMonumentBuriedTreasure(15, 9);

        grindSimulator.runSim(config);

        System.out.println(config.getResults());

//        System.out.println(config.getResults());
    }
}
