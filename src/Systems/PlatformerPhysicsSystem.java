
package src.Systems;

import src.Controller.PlatformerController;
import src.Physical.Physical;
import src.World.World;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author fabriziocasillas
 * @version 0.1
 * Handles vertical movement, gravity and jumping for platformer objects.
 */
public class PlatformerPhysicsSystem implements GameSystem {

    private static class BodyState {
        double velocityY = 0.0;
        double remainderY = 0.0;
        boolean grounded = false;
    }

    private final Physical player;
    private final PlatformerController controller;
    private final Map<Physical, BodyState> bodies = new HashMap<>();

    // changeee these values to change the jump.
    private final double gravity = 0.008;
    private final double jumpVelocity = -0.40;

    public PlatformerPhysicsSystem(
            Physical player,
            PlatformerController controller
    ) {
        this.player = player;
        this.controller = controller;
        bodies.put(player, new BodyState());
    }

    @Override
    public void update(World world) {
        if (!world.getPhysicals().contains(player)) {
            return;
        }

        BodyState body = bodies.get(player);

        // Check whether the player is standing on something solid.
        if (body.velocityY >= 0) {
            body.grounded = !world.canMove(player, 0, 1);

            if (body.grounded) {
                body.velocityY = 0;
                body.remainderY = 0;
            }
        }

        // Jump only when grounded.
        if (controller.consumeJumpRequest() && body.grounded) {
            body.velocityY = jumpVelocity;
            body.grounded = false;
        }

        // Apply gravity.
        if (!body.grounded) {
            body.velocityY += gravity;
            body.remainderY += body.velocityY;
        }

        // Convert fractional velocity into grid-cell movement.
        while (body.remainderY <= -1.0) {
            if (!world.move(player, 0, -1)) {
                body.velocityY = 0;
                body.remainderY = 0;
                break;
            }

            body.remainderY += 1.0;
        }

        while (body.remainderY >= 1.0) {
            if (!world.move(player, 0, 1)) {
                body.velocityY = 0;
                body.remainderY = 0;
                body.grounded = true;
                break;
            }

            body.remainderY -= 1.0;
        }

        // Refresh grounded state after vertical movement.
        if (body.velocityY >= 0) {
            body.grounded = !world.canMove(player, 0, 1);

            if (body.grounded) {
                body.velocityY = 0;
                body.remainderY = 0;
            }
        }
    }
}
