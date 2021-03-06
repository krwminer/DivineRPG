package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelEnderTriplets;
import naturix.divinerpg.entities.entity.vanilla.EnderTriplets;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEnderTriplets extends RenderLiving<EnderTriplets> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ender_triplets.png");
	private final ModelEnderTriplets ModelEnderTriplets;
    
	public RenderEnderTriplets(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnderTriplets(), 1F);
        ModelEnderTriplets = (ModelEnderTriplets) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EnderTriplets entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EnderTriplets> {

	        @Override
	        public Render<? super EnderTriplets> createRenderFor(RenderManager manager) {
	            return new RenderEnderTriplets(manager, new ModelEnderTriplets(), 0.5F);
	        }
	    }

	}