require 'test_helper'

class WfilesControllerTest < ActionController::TestCase
  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:wfiles)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create wfile" do
    assert_difference('Wfile.count') do
      post :create, :wfile => { }
    end

    assert_redirected_to wfile_path(assigns(:wfile))
  end

  test "should show wfile" do
    get :show, :id => wfiles(:one).to_param
    assert_response :success
  end

  test "should get edit" do
    get :edit, :id => wfiles(:one).to_param
    assert_response :success
  end

  test "should update wfile" do
    put :update, :id => wfiles(:one).to_param, :wfile => { }
    assert_redirected_to wfile_path(assigns(:wfile))
  end

  test "should destroy wfile" do
    assert_difference('Wfile.count', -1) do
      delete :destroy, :id => wfiles(:one).to_param
    end

    assert_redirected_to wfiles_path
  end
end
