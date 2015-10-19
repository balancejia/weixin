package balance.weixin.cms.entity;

import java.util.Date;

import org.smart4j.framework.orm.annotation.Entity;

@Entity
public class CmsContent {

	private long id;
	private long menuId;
	private long templetId;
	private String fs1;
	private String fs2;
	private String fs3;
	private String fs4;
	private String fs5;
	private String fs6;
	private String fs7;
	private String fs8;
	private String fs9;
	private String fs10;
	private int fi1;
	private int fi2;
	private int fi3;
	private int fi4;
	private int fi5;

	private Date ft1;
	private Date ft2;
	private Date ft3;
	private Date ft4;
	private Date ft5;

	private String ftext1;
	private String ftext2;
	private byte[] fblob1;
	private byte[] fblob2;

	private Date createTime;
	private Date updateTime;

	private String isAd;



	public String getIsAd() {
		return isAd;
	}

	public void setIsAd(String isAd) {
		this.isAd = isAd;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public long getTempletId() {
		return templetId;
	}

	public void setTempletId(long templetId) {
		this.templetId = templetId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFs1() {
		return fs1;
	}

	public void setFs1(String fs1) {
		this.fs1 = fs1;
	}

	public String getFs2() {
		return fs2;
	}

	public void setFs2(String fs2) {
		this.fs2 = fs2;
	}

	public String getFs3() {
		return fs3;
	}

	public void setFs3(String fs3) {
		this.fs3 = fs3;
	}

	public String getFs4() {
		return fs4;
	}

	public void setFs4(String fs4) {
		this.fs4 = fs4;
	}

	public String getFs5() {
		return fs5;
	}

	public void setFs5(String fs5) {
		this.fs5 = fs5;
	}

	public String getFs6() {
		return fs6;
	}

	public void setFs6(String fs6) {
		this.fs6 = fs6;
	}

	public String getFs7() {
		return fs7;
	}

	public void setFs7(String fs7) {
		this.fs7 = fs7;
	}

	public String getFs8() {
		return fs8;
	}

	public void setFs8(String fs8) {
		this.fs8 = fs8;
	}

	public String getFs9() {
		return fs9;
	}

	public void setFs9(String fs9) {
		this.fs9 = fs9;
	}

	public String getFs10() {
		return fs10;
	}

	public void setFs10(String fs10) {
		this.fs10 = fs10;
	}

	public int getFi1() {
		return fi1;
	}

	public void setFi1(int fi1) {
		this.fi1 = fi1;
	}

	public int getFi2() {
		return fi2;
	}

	public void setFi2(int fi2) {
		this.fi2 = fi2;
	}

	public int getFi3() {
		return fi3;
	}

	public void setFi3(int fi3) {
		this.fi3 = fi3;
	}

	public int getFi4() {
		return fi4;
	}

	public void setFi4(int fi4) {
		this.fi4 = fi4;
	}

	public int getFi5() {
		return fi5;
	}

	public void setFi5(int fi5) {
		this.fi5 = fi5;
	}

	public String getFtext1() {
		return ftext1;
	}

	public void setFtext1(String ftext1) {
		this.ftext1 = ftext1;
	}

	public String getFtext2() {
		return ftext2;
	}

	public void setFtext2(String ftext2) {
		this.ftext2 = ftext2;
	}

	public byte[] getFblob1() {
		return fblob1;
	}

	public void setFblob1(byte[] fblob1) {
		this.fblob1 = fblob1;
	}

	public byte[] getFblob2() {
		return fblob2;
	}

	public void setFblob2(byte[] fblob2) {
		this.fblob2 = fblob2;
	}

	public Date getFt1() {
		return ft1;
	}

	public void setFt1(Date ft1) {
		this.ft1 = ft1;
	}

	public Date getFt2() {
		return ft2;
	}

	public void setFt2(Date ft2) {
		this.ft2 = ft2;
	}

	public Date getFt3() {
		return ft3;
	}

	public void setFt3(Date ft3) {
		this.ft3 = ft3;
	}

	public Date getFt4() {
		return ft4;
	}

	public void setFt4(Date ft4) {
		this.ft4 = ft4;
	}

	public Date getFt5() {
		return ft5;
	}

	public void setFt5(Date ft5) {
		this.ft5 = ft5;
	}


}
