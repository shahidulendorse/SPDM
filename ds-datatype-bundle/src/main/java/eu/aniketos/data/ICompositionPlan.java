package eu.aniketos.data;

/**
 * Dummy placeholder interface describing a composition plan.
 * 
 * At this stage, composition plans are considered to be almost synonymous with
 * BPMN process specifications; however this will be updated as WP3/WP5(?) work
 * defines requirements
 * 
 * @author David Lamb, LJMU
 * @revised by Bernard Butler & Barry Mulcahy TSSG Aug 2011
 * 
 */
public interface ICompositionPlan
{
	public abstract String getCompositionPlanID();

	public abstract void setCompositionPlanID(String compositionPlanID);

    /**
     * Gets the BPMN XML String describing this composition plan
     * 
     * @return the BPMN description as an XML String
     */
    public String getBPMNXML();
}
