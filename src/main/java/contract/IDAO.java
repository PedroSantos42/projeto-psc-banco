package contract;

public interface IDAO {
	
	public void add(IEntity myEntity);
	
	public void update(IEntity myEntity);
	
	public void removeByPrimaryKey(IEntity myEntity, Object myPrimaryKey);
	
	public void removeByObject(IEntity myEntity);
	
	public IEntity listByPrimaryKey(Class myClass, Object myPrimaryKey);
	
	public IEntity listByObject(IEntity myEntity);
}
