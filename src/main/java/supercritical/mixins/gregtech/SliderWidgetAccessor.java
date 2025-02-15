package supercritical.mixins.gregtech;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.SliderWidget;

@Mixin(value = SliderWidget.class, remap = false)
public interface SliderWidgetAccessor {

    @Accessor("backgroundArea")
    TextureArea getBackgroundArea();

    @Accessor("sliderIcon")
    TextureArea getSliderIcon();

    @Accessor("sliderPosition")
    float getSliderPosition();

    @Accessor("sliderPosition")
    void setSliderPosition(float sliderPosition);

    @Accessor("min")
    float getMin();

    @Accessor("max")
    float getMax();

    @Accessor("displayString")
    String getDisplayStringRaw();

    @Accessor("displayString")
    void setDisplayStringRaw(String displayString);

    @Accessor("textColor")
    int getTextColor();

    @Accessor("sliderWidth")
    int getSliderWidth();
}
