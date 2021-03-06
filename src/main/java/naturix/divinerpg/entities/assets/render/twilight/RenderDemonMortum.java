package naturix.divinerpg.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelTwilightDemon;
import naturix.divinerpg.entities.entity.twilight.MortumDemon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDemonMortum extends RenderLiving<MortumDemon> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/demon_mortum.png");
	private final ModelTwilightDemon ModelTwilightDemon;
    
	public RenderDemonMortum(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTwilightDemon(), 1F);
        ModelTwilightDemon = (ModelTwilightDemon) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(MortumDemon entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<MortumDemon> {

	        @Override
	        public Render<? super MortumDemon> createRenderFor(RenderManager manager) {
	            return new RenderDemonMortum(manager, new ModelTwilightDemon(), 0.5F);
	        }
	    }

	}