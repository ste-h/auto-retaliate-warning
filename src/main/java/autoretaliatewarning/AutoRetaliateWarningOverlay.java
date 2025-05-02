package autoretaliatewarning;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.FontManager;
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
		graphics.setFont(new Font(FontManager.getRunescapeFont().getName(), Font.PLAIN, config.fontSize()));
		String autoRetaliateWarning = "AUTO RETALIATE IS SELECTED";
		String NPCAttackWarning = "NPC ATTACK OPTIONS NOT HIDDEN";
		String autoRetaliateOffWarning = "Do You Understand that your auto retaliate is off";
		boolean autoRetaliateSelected = plugin.getAutoRetaliateStatus();
		boolean getNPCAttackSelected = plugin.getNPCAttackOptions();

		if (autoRetaliateSelected && config.autoRetaliateWarn())
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(autoRetaliateWarning)
				.color(Color.RED)
				.build());
		}

		if (!autoRetaliateSelected && config.autoRetaliateOffWarn())
		{
			panelComponent.getChildren().add(TitleComponent.builder()
					.text(autoRetaliateOffWarning)
					.color(Color.RED)
					.build());
		}

		if (getNPCAttackSelected && config.npcAttackOptionsWarn())
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(NPCAttackWarning)
				.color(Color.RED)
				.build());
		}

		panelComponent.setPreferredSize(new Dimension(
			graphics.getFontMetrics().stringWidth(NPCAttackWarning) + 10,
			graphics.getFontMetrics().getHeight()));


		return super.render(graphics);
	}
}

