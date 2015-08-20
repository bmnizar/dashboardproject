package com.dashboard.model;

import com.dashboard.model.helper.EntityManagerHelper;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import org.primefaces.context.RequestContext;
import org.primefaces.model.StreamedContent;

 

@ManagedBean
@SessionScoped
public class Login {
	private String login;
	private String password;
	String image;
	private boolean adminSession = false;

	private StreamedContent imageStream;

	private String loginout = "Login";
	private boolean loged = false;

	private boolean mClient = false;

	private boolean renderImage = false;
	private static String WHOIS;

	

	public Login() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLoginout() {
		return loginout;
	}

	public void setLoginout(String loginout) {
		this.loginout = loginout;
	}

	public boolean isLoged() {
		return loged;
	}

	public void setLoged(boolean loged) {
		this.loged = loged;
	}

	public boolean ismClient() {
		return mClient;
	}

	public void setmClient(boolean mClient) {
		this.mClient = mClient;
	}

	public StreamedContent getImageStream() {
		return imageStream;
	}

	public void setImageStream(StreamedContent imageStream) {
		this.imageStream = imageStream;
	}

	public boolean isRenderImage() {
		return renderImage;
	}

	public void setRenderImage(boolean renderImage) {
		this.renderImage = renderImage;
	}

	public static String getWHOIS() {
		return WHOIS;
	}

	public static void setWHOIS(String wHOIS) {
		WHOIS = wHOIS;
	}

	

	

	public boolean isAdminSession() {
		return adminSession;
	}

	public void setAdminSession(boolean adminSession) {
		this.adminSession = adminSession;
	}

	@SuppressWarnings("rawtypes")
	public void connect() {

		RequestContext context = RequestContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Paramètres érronés", this.login);
		this.loginout = "Login";
		this.adminSession = false;
		this.loged = false;
		this.mClient = false;

		image = "";
		renderImage = false;
		WHOIS = "";
	

		SessionImpl sessionImpl = EntityManagerHelper.getSession();
		sessionImpl.beginTransaction();
		Criteria createCriteria = sessionImpl.createCriteria(BankUser.class);
		createCriteria.add(Restrictions.eq("login", login));
		createCriteria.add(Restrictions.eq("password", password));

		List list = createCriteria.list();
		if (list.size() > 0) {

			this.loginout = "Logout";
			this.adminSession = true;
			this.loged = true;

			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome",
					this.login);

			this.mClient = true;

			WHOIS = "admin";

			sessionImpl.getTransaction().commit();

			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("loggedIn", this.loged);

			String url = "Accueil.xhtml";
			FacesContext fc = FacesContext.getCurrentInstance();
			ExternalContext ec = fc.getExternalContext();

			try {
				ec.redirect(url);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}

}
