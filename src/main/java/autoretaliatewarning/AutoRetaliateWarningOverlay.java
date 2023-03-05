package autoretaliatewarning;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class AutoRetaliateWarningOverlay extends OverlayPanel
{
	private final AutoRetaliateWarningPlugin plugin;
	private final AutoRetaliateWarningConfig config;

	@Inject
	private AutoRetaliateWarningOverlay(AutoRetaliateWarningPlugin plugin, AutoRetaliateWarningConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		boolean autoRetaliateSelected = plugin.getAutoRetaliateStatus();
		if (autoRetaliateSelected) {
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("AUTO RETALIATE IS SELECTED")
			.color(Color.RED)
			.build());

		panelComponent.setPreferredSize(new Dimension(
			graphics.getFontMetrics().stringWidth("AUTO RETALIATE IS SELECTED") + 10,
			0));

		return super.render(graphics);
	}
		return null;
	}
}

