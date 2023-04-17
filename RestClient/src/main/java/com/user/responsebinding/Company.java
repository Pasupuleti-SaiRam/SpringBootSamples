package com.user.responsebinding;

public class Company {
	
	 public String name;
	    public String catchPhrase;
	    public String bs;
	    public Company() {
			// TODO Auto-generated constructor stub
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCatchPhrase() {
			return catchPhrase;
		}
		public void setCatchPhrase(String catchPhrase) {
			this.catchPhrase = catchPhrase;
		}
		public String getBs() {
			return bs;
		}
		public void setBs(String bs) {
			this.bs = bs;
		}
		@Override
		public String toString() {
			return "Company [name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
		}
	    

}
