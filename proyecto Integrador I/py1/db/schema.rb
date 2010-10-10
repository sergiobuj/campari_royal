# This file is auto-generated from the current state of the database. Instead of editing this file, 
# please use the migrations feature of Active Record to incrementally modify your database, and
# then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your database schema. If you need
# to create the application database on another system, you should be using db:schema:load, not running
# all the migrations from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended to check this file into your version control system.

ActiveRecord::Schema.define(:version => 20081120154459) do

  create_table "lists", :force => true do |t|
    t.string   "name"
    t.datetime "date"
    t.integer  "user_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "lists_products", :id => false, :force => true do |t|
    t.integer "list_id"
    t.integer "product_id"
  end

  add_index "lists_products", ["list_id", "product_id"], :name => "index_lists_products_on_list_id_and_product_id", :unique => true

  create_table "products", :force => true do |t|
    t.string   "name"
    t.string   "section"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.integer  "ubication_id"
  end

  create_table "ubications", :force => true do |t|
    t.string   "name"
    t.integer  "x"
    t.integer  "y"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "users", :force => true do |t|
    t.string   "login"
    t.string   "email"
    t.string   "crypted_password",          :limit => 40
    t.string   "salt",                      :limit => 40
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "remember_token"
    t.datetime "remember_token_expires_at"
    t.string   "firstname"
    t.string   "lastname"
    t.boolean  "is_admin"
  end

end
