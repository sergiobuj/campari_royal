class CreateWfiles < ActiveRecord::Migration
  def self.up
    create_table :wfiles do |t|
      t.string :name
      t.string :owner
      t.string :id
      t.string :type

      t.timestamps
    end
  end

  def self.down
    drop_table :wfiles
  end
end
