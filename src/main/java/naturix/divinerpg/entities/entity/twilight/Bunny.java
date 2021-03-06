package naturix.divinerpg.entities.entity.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class Bunny extends EntityMob {

    public Bunny(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 0.7f);
		this.setHealth(this.getMaxHealth());
	}
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/bunny");


    protected boolean isMaster() {
        return false;
    }

    @Override
    protected boolean canDespawn() {
        return true;
    }

    private ResourceLocation deathLootTable = LOOT;

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.1D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(55.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    }

    protected void initEntityAI()
    {
    	this.tasks.addTask(4, new EntityAIFindEntityNearest(this, Bunny.class));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAIFollow(this, 1, 1, 1));
        this.tasks.addTask(10, new EntityAISwimming(this));
        this.applyEntityAI();
    }

    private void applyEntityAI() {
        }


    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }

    @Override
    public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn) {
        super.setAttackTarget(entitylivingbaseIn);
        if (entitylivingbaseIn instanceof EntityPlayer) {
            
        }
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        super.playStepSound(pos, blockIn);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }
    @Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;

	}

    @Override
    protected void onDeathUpdate()
    {
    	this.updateArmSwingProgress();
        float f = this.getBrightness();

        if (f > 0.5F)
        {
            this.idleTime += 2;
        }

        super.onLivingUpdate();
        ++this.deathTime;

        if (this.deathTime == 20)
        {
        	AngryBunny bunny = new AngryBunny(world);
        	bunny.setLocationAndAngles(getPosition().getX(), getPosition().getY(), getPosition().getZ(), this.prevRotationYaw, this.rotationPitch);
        	
    		bunny.setPosition(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ());
    		if(!world.isRemote) {
    		world.spawnEntity(bunny);
    		this.isDead = true;
    		}
        }
    }
    protected Block spawnableBlock = ModBlocks.grassEden;

    @Override
    public boolean getCanSpawnHere()
    {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && world.provider.getDimension() == ModDimensions.edenDimension.getId();
    }
    }
