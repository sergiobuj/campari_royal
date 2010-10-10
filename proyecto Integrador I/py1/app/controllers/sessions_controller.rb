# This controller handles the login/logout function of the site.
class SessionsController < ApplicationController
 
  def new
  end
  # to create a sessions login
  def create
    self.current_user = User.authenticate(params[:login], params[:password])
    if logged_in?
      if params[:remember_me] == "1"
        current_user.remember_me unless current_user.remember_token?
        cookies[:auth_token] = { :value => self.current_user.remember_token , :expires => self.current_user.remember_token_expires_at }
      end
      redirect_back_or_default('/')
      flash[:notice] = "Sesión iniciada"
    else
      render :action => 'new'
    end
  end
  
  #to close the session
  def destroy
    self.current_user.forget_me if logged_in?
    cookies.delete :auth_token
    reset_session
    flash[:notice] = "La sesión se ha cerrado."
    redirect_back_or_default('/')
  end
end
