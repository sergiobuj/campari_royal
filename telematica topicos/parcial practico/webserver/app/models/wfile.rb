class Wfile < ActiveRecord::Base

  attr_accessor :name, :type , :id

  def initialize name, type
    @name = name
    @type = type
    @id = name.gsub('/',';').gsub(' ',',').gsub('.', '=')
  end

def self.indexall
  
  
end

def to_s
  @name
end
end
