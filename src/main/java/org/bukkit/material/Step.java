package org.bukkit.material;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the different types of steps.
 */
public class Step extends TexturedMaterial {
    private static final List<Material> textures = new ArrayList<Material>();

    static {
        textures.add(Material.STONE);
        textures.add(Material.SANDSTONE);
        textures.add(Material.WOOD);
        textures.add(Material.COBBLESTONE);
        textures.add(Material.BRICK);
        textures.add(Material.SMOOTH_BRICK);
        textures.add(Material.NETHER_BRICK);
        textures.add(Material.QUARTZ_BLOCK);
    }

    public Step() {
        super(Material.STEP);
    }

    /**
     * @param type the raw type id
     * @deprecated Magic value
     */

    public Step(final int type) {
        super(type);
    }

    public Step(final Material type) {
        super((textures.contains(type)) ? Material.STEP : type);
        if (textures.contains(type)) {
            setMaterial(type);
        }
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated Magic value
     */

    public Step(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated Magic value
     */

    public Step(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public List<Material> getTextures() {
        return textures;
    }

    /**
     * Test if step is inverted
     *
     * @return true if inverted (top half), false if normal (bottom half)
     */
    public boolean isInverted() {
        return ((getData() & 0x8) != 0);
    }

    /**
     * Set step inverted state
     *
     * @param inv - true if step is inverted (top half), false if step is
     *     normal (bottom half)
     */
    public void setInverted(boolean inv) {
        int dat = getData() & 0x7;
        if (inv) {
            dat |= 0x8;
        }
        setData((byte) dat);
    }

    /**
     *
     * @deprecated Magic value
     */

    @Override
    protected int getTextureIndex() {
        return getData() & 0x7;
    }

    /**
     *
     * @deprecated Magic value
     */

    @Override
    protected void setTextureIndex(int idx) {
        setData((byte) ((getData() & 0x8) | idx));
    }

    @Override
    public Step clone() {
        return (Step) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + (isInverted() ? "inverted" : "");
    }
}
