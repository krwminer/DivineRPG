package net.divinerpg.client.render.item;

import net.divinerpg.client.render.block.model.ModelEdenChest;
import net.divinerpg.libs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRendererBoneChest implements IItemRenderer {

	private ModelEdenChest model;
	private ResourceLocation texture = new ResourceLocation(Reference.PREFIX + "textures/model/boneChest.png");
	
	public ItemRendererBoneChest() {
		model = new ModelEdenChest();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		switch(type) {
		case INVENTORY:
			GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(0.0F, -0.1F, 0.0F);
		case EQUIPPED:
			GL11.glRotatef(180F, 0.0F, 0.0F, 0.1F);
			GL11.glTranslatef(-1.0F, -1.0F, -0.0F);
		default:
		}
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		model.renderAll();
		GL11.glPopMatrix();
	}
}