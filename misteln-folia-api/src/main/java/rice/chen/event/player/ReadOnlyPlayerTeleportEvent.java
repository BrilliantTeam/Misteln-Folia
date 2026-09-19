package rice.chen.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Set;

/**
 * Fired when a player is teleported via teleportAsync. This event is read-only
 * and cannot cancel or modify the teleport — it is intended for observation only.
 */
public class ReadOnlyPlayerTeleportEvent extends PlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Location from;
    private final Location to;
    private final PlayerTeleportEvent.TeleportCause cause;
    private final Set<io.papermc.paper.entity.TeleportFlag.Relative> relativeFlags;

    public ReadOnlyPlayerTeleportEvent(
            @NotNull Player player,
            @NotNull Location from,
            @Nullable Location to,
            @NotNull PlayerTeleportEvent.TeleportCause cause,
            @NotNull Set<io.papermc.paper.entity.TeleportFlag.Relative> relativeFlags) {
        super(player);
        this.from = from;
        this.to = to;
        this.cause = cause;
        this.relativeFlags = relativeFlags;
    }

    @NotNull
    public Location getFrom() {
        return from;
    }

    @Nullable
    public Location getTo() {
        return to;
    }

    @NotNull
    public PlayerTeleportEvent.TeleportCause getCause() {
        return cause;
    }

    @NotNull
    public Set<io.papermc.paper.entity.TeleportFlag.Relative> getRelativeFlags() {
        return relativeFlags;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
