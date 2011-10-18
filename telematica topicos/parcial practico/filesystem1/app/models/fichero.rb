class Fichero < ActiveRecord::Base
  attr_accessor :path ,:id

  # <?xml version="1.0" encoding="UTF-8"?>
  # <files type="array">
  # <file>
  # <id type="string">"#{id}"</id>
  # <name>"#{name}"</name>
  # <type> </type>
  # </file>
  # </file>
  # </xml>

  def initialize _path
    @path = _path
    @id = @path
  end

  def self.find id
    ficheros = Array.new
    if File.directory? id
      arreglof = Dir.glob(id+"/*")
      arreglof.each { | x | 
        ficheros << Fichero.new(x)
      }
    end
    ficheros
  end

  def get_all
    Dir.glob path
  end

end
