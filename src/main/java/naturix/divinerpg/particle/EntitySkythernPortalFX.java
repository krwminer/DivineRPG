package naturix.divinerpg.particle;


import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class EntitySkythernPortalFX extends Particle {

	private float portalParticleScale;
	private double portalPosX, portalPosY, portalPosZ;

	public EntitySkythernPortalFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1, var2, var4, var6, var8, var10, var12);
		this.motionX = var8;
		this.motionY = var10;
		this.motionZ = var12;
		this.portalPosX = this.posX = var2;
		this.portalPosY = this.posY = var4;
		this.portalPosZ = this.posZ = var6;
		float var14 = this.rand.nextFloat() * 0.6F + 0.4F;
		this.portalParticleScale = this.particleScale = this.rand.nextFloat() * 0.2F + 0.5F;
		this.particleMaxAge = (int)(Math.random() * 10.0D) + 40;
		this.canCollide = true;
		this.setParticleTextureIndex((int)(Math.random() * 8.0D));
	}

	@Override
	public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float getBrightnessForRender, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    	{
		float var8 = (this.particleAge + partialTicks) / this.particleMaxAge;
		var8 = 1.0F - var8;
		var8 *= var8;
		var8 = 1.0F - var8;
		this.particleScale = this.portalParticleScale * var8;
		super.renderParticle(buffer, entityIn, partialTicks, getBrightnessForRender, rotationZ, rotationYZ, rotationXY, rotationXZ);
	}

	@Override
	public int getBrightnessForRender(float var1) {
		int var2 = super.getBrightnessForRender(var1);
		float var3 = (float)this.particleAge / (float)this.particleMaxAge;
		var3 *= var3;
		var3 *= var3;
		int var4 = var2 & 255;
		int var5 = var2 >> 16 & 255;
		var5 += (int)(var3 * 15.0F * 16.0F);
		if(var5 > 240) 
			var5 = 240;
		return var4 | var5 << 16;
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		float var1 = (float)this.particleAge / (float)this.particleMaxAge;
		float var2 = var1;
		var1 = -var1 + var1 * var1 * 2.0F;
		var1 = 1.0F - var1;
		this.posX = this.portalPosX + this.motionX * var1;
		this.posY = this.portalPosY + this.motionY * var1 + (1.0F - var2);
		this.posZ = this.portalPosZ + this.motionZ * var1;
		if(this.particleAge++ >= this.particleMaxAge) 
			this.setExpired();	
	}
}
