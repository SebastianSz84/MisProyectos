USE [master]
GO
/****** Object:  Database [AD_Final_Productos] Script Date: 09/27/2015 17:29:22 ******/
if (DB_ID('AD_Final_Productos') != 0)
begin
	ALTER DATABASE [AD_Final_Productos] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;

	DROP DATABASE [AD_Final_Productos];
end
go

CREATE DATABASE [AD_Final_Productos]
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [AD_Final_Productos].[dbo].[sp_fulltext_database] @action = 'disable'
end
GO
ALTER DATABASE [AD_Final_Productos] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET ARITHABORT OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [AD_Final_Productos] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [AD_Final_Productos] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [AD_Final_Productos] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [AD_Final_Productos] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [AD_Final_Productos] SET  READ_WRITE 
GO
ALTER DATABASE [AD_Final_Productos] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [AD_Final_Productos] SET  MULTI_USER 
GO
ALTER DATABASE [AD_Final_Productos] SET PAGE_VERIFY CHECKSUM  
GO
USE [AD_Final_Productos]
GO
IF NOT EXISTS (SELECT name FROM sys.filegroups WHERE is_default=1 AND name = N'PRIMARY') ALTER DATABASE [AD_Final_Productos] MODIFY FILEGROUP [PRIMARY] DEFAULT
GO

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[compuestoDe]    Script Date: 12/19/2015 7:49:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[compuestoDe](
	[codProductoE] [int] NOT NULL,
	[codProductoSE] [int] NOT NULL,
 CONSTRAINT [PK_compuestoDe] PRIMARY KEY CLUSTERED 
(
	[codProductoE] ASC,
	[codProductoSE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[elaborados]    Script Date: 12/19/2015 7:49:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[elaborados](
	[codProducto] [int] NOT NULL IDENTITY(1,1),
	[descripcion] [varchar](50) NULL,
	[precioVenta] [float] NULL,
	[porcentajeGanancia] [int] NULL,
	[unidad] [int] NULL,
 CONSTRAINT [PK_elaborados] PRIMARY KEY CLUSTERED 
(
	[codProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[materiales]    Script Date: 12/19/2015 7:49:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[materiales](
	[codMaterial] [varchar](50) NOT NULL,
	[descripcion] [varchar](50) NULL,
	[uniCompra] [int] NULL,
	[uniUso] [int] NULL,
 CONSTRAINT [PK_materiales] PRIMARY KEY CLUSTERED 
(
	[codMaterial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[materialSemi]    Script Date: 12/19/2015 7:49:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[materialSemi](
	[codProducto] [int] NOT NULL,
	[codMaterial] [varchar](50) NOT NULL,
 CONSTRAINT [PK_materialSemi] PRIMARY KEY CLUSTERED 
(
	[codProducto] ASC,
	[codMaterial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[semiElaborados]    Script Date: 12/19/2015 7:49:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[semiElaborados](
	[codProducto] [int] NOT NULL IDENTITY(1,1),
	[descripcion] [varchar](50) NULL,
	[costo] [float] NULL,
	[almacenadoComo] [int] NULL,
 CONSTRAINT [PK_semiElaborados] PRIMARY KEY CLUSTERED 
(
	[codProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[unidades]    Script Date: 12/19/2015 7:49:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[unidades](
	[codUnidad] [int] NOT NULL,
	[descripcion] [varchar](50) NULL,
 CONSTRAINT [PK_unidades] PRIMARY KEY CLUSTERED 
(
	[codUnidad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[compuestoDe]  WITH CHECK ADD  CONSTRAINT [FK_compuestoDe_elaborados] FOREIGN KEY([codProductoE])
REFERENCES [dbo].[elaborados] ([codProducto])
GO
ALTER TABLE [dbo].[compuestoDe] CHECK CONSTRAINT [FK_compuestoDe_elaborados]
GO
ALTER TABLE [dbo].[compuestoDe]  WITH CHECK ADD  CONSTRAINT [FK_compuestoDe_semiElaborados] FOREIGN KEY([codProductoSE])
REFERENCES [dbo].[semiElaborados] ([codProducto])
GO
ALTER TABLE [dbo].[compuestoDe] CHECK CONSTRAINT [FK_compuestoDe_semiElaborados]
GO
ALTER TABLE [dbo].[elaborados]  WITH CHECK ADD  CONSTRAINT [FK_elaborados_unidades] FOREIGN KEY([unidad])
REFERENCES [dbo].[unidades] ([codUnidad])
GO
ALTER TABLE [dbo].[elaborados] CHECK CONSTRAINT [FK_elaborados_unidades]
GO
ALTER TABLE [dbo].[materiales]  WITH CHECK ADD  CONSTRAINT [FK_materiales_unidades] FOREIGN KEY([uniCompra])
REFERENCES [dbo].[unidades] ([codUnidad])
GO
ALTER TABLE [dbo].[materiales] CHECK CONSTRAINT [FK_materiales_unidades]
GO
ALTER TABLE [dbo].[materiales]  WITH CHECK ADD  CONSTRAINT [FK_materiales_unidades1] FOREIGN KEY([uniUso])
REFERENCES [dbo].[unidades] ([codUnidad])
GO
ALTER TABLE [dbo].[materiales] CHECK CONSTRAINT [FK_materiales_unidades1]
GO
ALTER TABLE [dbo].[materialSemi]  WITH CHECK ADD  CONSTRAINT [FK_materialSemi_materiales] FOREIGN KEY([codMaterial])
REFERENCES [dbo].[materiales] ([codMaterial])
GO
ALTER TABLE [dbo].[materialSemi] CHECK CONSTRAINT [FK_materialSemi_materiales]
GO
ALTER TABLE [dbo].[materialSemi]  WITH CHECK ADD  CONSTRAINT [FK_materialSemi_semiElaborados] FOREIGN KEY([codProducto])
REFERENCES [dbo].[semiElaborados] ([codProducto])
GO
ALTER TABLE [dbo].[materialSemi] CHECK CONSTRAINT [FK_materialSemi_semiElaborados]
GO
ALTER TABLE [dbo].[semiElaborados]  WITH CHECK ADD  CONSTRAINT [FK_semiElaborados_unidades] FOREIGN KEY([almacenadoComo])
REFERENCES [dbo].[unidades] ([codUnidad])
GO
ALTER TABLE [dbo].[semiElaborados] CHECK CONSTRAINT [FK_semiElaborados_unidades]
GO

INSERT INTO [AD_Final_Productos].[dbo].[unidades] VALUES ('1','CM')
INSERT INTO [AD_Final_Productos].[dbo].[unidades] VALUES ('2','IN')

INSERT INTO [AD_Final_Productos].[dbo].[materiales] VALUES ('MAT1','Material 1','1','1')
INSERT INTO [AD_Final_Productos].[dbo].[materiales] VALUES ('MAT2','Material 2','2','2')