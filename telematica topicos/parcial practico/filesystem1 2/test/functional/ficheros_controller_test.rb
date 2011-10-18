require 'test_helper'

class FicherosControllerTest < ActionController::TestCase
  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:ficheros)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create fichero" do
    assert_difference('Fichero.count') do
      post :create, :fichero => { }
    end

    assert_redirected_to fichero_path(assigns(:fichero))
  end

  test "should show fichero" do
    get :show, :id => ficheros(:one).to_param
    assert_response :success
  end

  test "should get edit" do
    get :edit, :id => ficheros(:one).to_param
    assert_response :success
  end

  test "should update fichero" do
    put :update, :id => ficheros(:one).to_param, :fichero => { }
    assert_redirected_to fichero_path(assigns(:fichero))
  end

  test "should destroy fichero" do
    assert_difference('Fichero.count', -1) do
      delete :destroy, :id => ficheros(:one).to_param
    end

    assert_redirected_to ficheros_path
  end
end
