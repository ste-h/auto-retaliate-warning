package autoretaliatewarning;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.OverlayManager;


@Slf4j
@PluginDescriptor(
	name = "Auto Retaliate Warning"
)


public class AutoRetaliateWarningPlugin extends Plugin
{
	private final int AUTO_RETALIATE_VARBIT = 172;
	@Inject
	private Client client;

	@Inject
	private AutoRetaliateWarningConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AutoRetaliateWarningOverlay overlay;

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		hideWidget(client.getWidget(WidgetInfo.COMBAT_AUTO_RETALIATE), config.hideRetaliateConfig());
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		hideWidget(client.getWidget(WidgetInfo.COMBAT_AUTO_RETALIATE), config.hideRetaliateConfig());
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		log.info("Auto Retaliate Warning stopped!");
		hideWidget(client.getWidget(WidgetInfo.COMBAT_AUTO_RETALIATE), false);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			return;
		}
	}

	@Provides
	AutoRetaliateWarningConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AutoRetaliateWarningConfig.class);
	}

	private void hideWidget(Widget widget, boolean hidden)
	{
		if (widget != null)
		{
			widget.setHidden(hidden);
		}
	}

	public boolean getAutoRetaliateStatus() {
		return client.getVarpValue(AUTO_RETALIATE_VARBIT) == 0;
	}
}

