class FicherosController < ApplicationController

  # GET /ficheros
  # GET /ficheros.xml
  def index
    @fich = Fichero.new File.open("#{RAILS_ROOT}/config/export.conf").gets
    @ficheros = @fich.get_all
    #    @ficheros.map! { |x| x.split('/').join('-').split(' ').join('+') }
    #@ficheros.map! { |x| x.gsub('/',';').gsub(' ',',').gsub('.', '=') }
    # respond_to do |format|
    #       format.html # index.html.erb
    #       format.xml  { render :xml => @ficheros }
    full = ""
      @ficheros.each do |fichero|
        dir = File.directory?(fichero) ? "1" : "0"
        full += "#{fichero}=>#{dir}sN3r0l"
    end
      render :text => full
  end

  # GET /ficheros/1
  # GET /ficheros/1.xml
  def show
    #    path = params[:id].split('+').join(' ').split('-').join('/')
    path = params[:id].gsub(';','/').gsub(',',' ').gsub('=', '.')

    if File.directory? path
      @ficheros = Fichero.find(path)
      #@ficheros.map! { |x| x.id.split('/').join('-').split(' ').join('+') }
      #@ficheros.map! { |x| x.id.gsub('/',';').gsub(' ',',').gsub('.', '=') }
     
     
     
      full = ""
        @ficheros.each do |fichero|
          dir = File.directory?(fichero.path) ? "1" : "0"
          full += "#{fichero.path}=>#{dir}sN3r0l"
      end
      
      
      
      
        render :text => full
     
         #   
         # respond_to do |format|
         #   format.html # show.html.erb
         #   format.xml  { render :xml => @ficheros }
         # 
         # end
   
    else
      send_file path
    end
  end


end
