package com.kd.platform.core.common.hibernate.qbc;

import java.util.ArrayList;

import org.hibernate.criterion.Criterion;

/**
 * <b>Application name:</b> CriterionList.java <br>
 * <b>Application describing:查询条件集合 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class CriterionList extends ArrayList<Object> {

    private static final long serialVersionUID = 1L;

    public final Criterion getParas(final int index) {
        return (Criterion) super.get(index);
    }

    public final void addPara(final int index, final Criterion p) {
        super.add(index, p);
    }

    public final void addPara(final Criterion p) {
        super.add(p);
    }

    public final int indexofPara(final Criterion p) {
        return super.indexOf(p);
    }

    public final void removePara(final int index) {
        super.remove(index);
    }
}
