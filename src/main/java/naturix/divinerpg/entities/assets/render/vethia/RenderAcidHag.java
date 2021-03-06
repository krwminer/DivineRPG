package naturix.divinerpg.entities.assets.render.vethia;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelAcidHag;
import naturix.divinerpg.entities.entity.vethia.AcidHag;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAcidHag extends RenderLiving<AcidHag> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/hag_acid.png");
	private final ModelAcidHag modelEntity;
    
	public RenderAcidHag(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAcidHag(), 1F);
        modelEntity = (ModelAcidHag) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(AcidHag entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<AcidHag> {

	        @Override
	        public Render<? super AcidHag> createRenderFor(RenderManager manager) {
	            return new RenderAcidHag(manager, new ModelAcidHag(), 1F);
	        }
	    }

	}